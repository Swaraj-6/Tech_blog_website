<%@page import="com.techBlog.dao.UserDao"%>
<%@page import="com.techBlog.entities.Post"%>
<%@page import="java.util.List"%>
<%@page import="com.techBlog.helper.ConnectionProvider"%>
<%@page import="com.techBlog.dao.PostDao"%>

<div class="row">
    <%
        Thread.sleep(500);
        PostDao dao = new PostDao(ConnectionProvider.getConnection());

        int cid = Integer.parseInt(request.getParameter("cid"));
        List<Post> posts = null;

        if (cid == 0) {
            posts = dao.getAllPost();
        } else {
            posts = dao.getPostByCatId(cid);
        }

        UserDao userdao = new UserDao(ConnectionProvider.getConnection());

        if (posts.size() == 0) {
            out.println("<h3 class='display-3 text-center'>No Posts in this category...</h3>");
            return;
        }

        for (Post p : posts) {
    %>

    <div class="col-md-6 mt-2">
        <div class="card">

            <img class="card-img-top" src="blog_pics/<%= p.getpPic()%>">
            <div class="card-body">
                <b><%= p.getpTitle()%> </b>
                <br>
                <br>
                <details>
                    <summary>Click here to read...</summary>
                    <p><%= p.getpContent()%></p>
                </details>
                <br>
                <details>
                    <summary>Click here to read code...</summary>
                    <pre><%= p.getpCode()%></pre>
                </details>
                <br>

                <p><%= p.getpDate()%></p>
                <p>By - <%= userdao.getUserNameById(p.getUserId())%></p>
            </div>

        </div> 
    </div>

    <%
        }
    %>
</div>