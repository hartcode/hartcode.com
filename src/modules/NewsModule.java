package modules;

import javax.servlet.http.HttpServletRequest;

import dataObjects.HTMLNews;

public class NewsModule  implements IMainModule {
			protected HttpServletRequest m_request;
			public NewsModule()
			{
				
			}
			public String GetMainModule() {
				StringBuilder sb = new StringBuilder();
				HTMLNews hnews = new HTMLNews();
				sb.append(hnews.toString());
				return sb.toString();
			}
			public void SetRequest(HttpServletRequest request)
			{
				m_request = request;
				
			}

}
