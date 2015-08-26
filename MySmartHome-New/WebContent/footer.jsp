<%@page import="java.net.Inet4Address"%>
<%@page import="java.net.InterfaceAddress"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.net.NetworkInterface"%>
<%@page import="java.net.InetAddress"%>
<footer class="section">
	<div class="container">
		<div class="row">
			<div class="col-sm-6" style="text-align: text-right">
				<div class="" style="color: white">
					Product of Champ Brains
					<p contenteditable="true" class="" style="color: white">Contect
					No : xxxxx</p>
					<%
					
					for (
						    final Enumeration< NetworkInterface > interfaces =
						        NetworkInterface.getNetworkInterfaces( );
						    interfaces.hasMoreElements( );
						)
						{
						    final NetworkInterface cur = interfaces.nextElement( );

						    if ( cur.isLoopback( ) )
						    {
						        continue;
						    }
						    
						    for ( final InterfaceAddress addr : cur.getInterfaceAddresses( ) )
						    {
						        final InetAddress inet_addr = addr.getAddress( );

						        if ( !( inet_addr instanceof Inet4Address ) )
						        {
						            continue;
						        }
					%>
								<%=" address: " + inet_addr.getHostAddress() %>
								<br>
					<%
						    }
						}						
					
					%>
					<FORM>
						<INPUT TYPE="button" onClick="history.go(0)" VALUE="Refresh">
					</FORM>
				</div>
				
			</div>
			<div class="col-sm-6 text-right">
				<iframe src="clock.html" frameBorder="0" seamless='seamless' height="70px"></iframe>
			</div>
		</div>
	</div>
</footer>