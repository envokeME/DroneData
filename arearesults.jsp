<html>

  <body>

      <br />
      <h2 style="text-align:center;background-color:gray;color:white">DRONE RECON</h2>

     <%@ page import="com.dronerecon.ws.AreaGridTile" %>
      <%@ page import="com.dronerecon.ws.DBManager" %>
	  <%@ page import="java.util.ArrayList" %>
	  
	  
	  <%
    String Area_ID = request.getParameter("area_id");
		%>
		
		<%
		DBManager oDBManager = new DBManager();
		%>
		
		<%
		oDBManager.DBLocation = System.getProperty("catalina.base") +              
"\\webapps\\dronereconportal\\db\\" + oDBManager.DBLocation;
		%>
		
		<%
		readAreaGridTiles(Area_ID);
		%>
		
		<%
		 for (AreaGridTile values : lstTiles) 
		 { 		      
           System.out.println(values); 		
		}
		%>
		
		
		
  </body>
</html>