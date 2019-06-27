package web;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Crawler1 {
		  private Set<String> pagesVisited = new HashSet<String>();
		  private List<String> pagesToVisit = new LinkedList<String>();
		  private List<String> link = new LinkedList<String>();
		  public void search(String url)
		  {
			  int i=0;
		      while(i<4)
		      {
		          String currentUrl;
		          Crawler leg = new Crawler();
		          if(this.pagesToVisit.isEmpty())
		          {
		        	  i=i+1;
		              currentUrl = url;
		              this.pagesVisited.add(url);
		          }
		          else
		          {
		              currentUrl = this.nextUrl();
		          }
		          leg.crawl(currentUrl);
		          link=leg.getLinks();
		          for(int j=0;j<link.size();j++)
		          {
		        	  System.out.println(link.get(j));
		          }
		         
		      }
		  }
		  private String nextUrl()
		  {
		      String nextUrl;
		      do
		      {
		          nextUrl = this.pagesToVisit.remove(0);
		      } while(this.pagesVisited.contains(nextUrl));
		      this.pagesVisited.add(nextUrl);
		      return nextUrl;
		  }

}
