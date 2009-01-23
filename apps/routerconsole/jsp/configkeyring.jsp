<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html><head>
<title>I2P Router Console - config keyring</title>
<link rel="stylesheet" href="default.css" type="text/css" />
</head><body>

<%@include file="nav.jsp" %>
<%@include file="summary.jsp" %>

<div class="main" id="main">
 <%@include file="confignav.jsp" %>
  
 <jsp:useBean class="net.i2p.router.web.ConfigKeyringHandler" id="formhandler" scope="request" />
 <jsp:setProperty name="formhandler" property="*" />
 <jsp:setProperty name="formhandler" property="contextId" value="<%=(String)session.getAttribute("i2p.contextId")%>" />
 <font color="red"><jsp:getProperty name="formhandler" property="errors" /></font>
 <i><jsp:getProperty name="formhandler" property="notices" /></i>
 


 <jsp:useBean class="net.i2p.router.web.ConfigKeyringHelper" id="keyringhelper" scope="request" />
 <jsp:setProperty name="keyringhelper" property="contextId" value="<%=(String)session.getAttribute("i2p.contextId")%>" />

 <p>
 <h2>Keyring</h2>
 The router keyring is used to decrypt encrypted leaseSets.
 The keyring may contain keys for local or remote encrypted destinations.
 <p><jsp:getProperty name="keyringhelper" property="summary" />
 </p>

 <hr />

 <form action="configkeyring.jsp" method="POST">
 <% String prev = System.getProperty("net.i2p.router.web.ConfigKeyringHandler.nonce");
    if (prev != null) System.setProperty("net.i2p.router.web.ConfigKeyringHandler.noncePrev", prev);
    System.setProperty("net.i2p.router.web.ConfigKeyringHandler.nonce", new java.util.Random().nextLong()+""); %>
 <input type="hidden" name="nonce" value="<%=System.getProperty("net.i2p.router.web.ConfigKeyringHandler.nonce")%>" />
 <h2>Manual Keyring Addition</h2>
 Enter keys for encrypted remote destinations here.
 Keys for local destinations must be entered on the <a href="i2ptunnel/index.jsp">I2PTunnel page</a>.
 <p>
 <table>
 <tr><td>Dest. name, hash, or full key:
 <td><textarea name="peer" cols="44" rows="1" wrap="off"></textarea>
 <tr><td align="right">Session Key:
 <td><input type="text" size="55" name="key" />
 <tr><td><td><input type="submit" name="action" value="Add key" />
 </table>
 </form>


</div>

</body>
</html>