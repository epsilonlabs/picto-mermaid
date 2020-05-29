package org.eclipse.epsilon.picto.mermaid;

import org.eclipse.epsilon.picto.PictoView;
import org.eclipse.epsilon.picto.ViewContent;
import org.eclipse.epsilon.picto.transformers.ViewContentTransformer;

public class MermaidContentTransformer implements ViewContentTransformer {

	@Override
	public boolean canTransform(ViewContent content) {
		return content.getFormat().equals("mermaid");
	}

	@Override
	public String getLabel(ViewContent content) {
		return "Mermaid";
	}

	@Override
	public ViewContent transform(ViewContent content, PictoView pictoView) throws Exception {
		
		String html = "<div><script src=\"https://cdnjs.cloudflare.com/ajax/libs/mermaid/7.1.2/mermaid.min.js\"></script>\n" + 
				"<script>\n" + 
				"mermaid.initialize({startOnLoad:true});\n" + 
				"</script>";
		
		html += "<div class=\"mermaid\">\n" + content.getText() + "</div></div>";
		
		return new ViewContent("svg", html, content.getFile(), content.getLayers(), content.getPatches());
	}

}
