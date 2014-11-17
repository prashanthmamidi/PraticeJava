package com.websocket;

import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by mami01 on 17/03/14.
 */

  public class WebSocketChatServlet extends WebSocketServlet {
        private final Set _members = new CopyOnWriteArraySet();

        protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException,IOException {
            getServletContext().getNamedDispatcher("default").forward(request,response);
        }

        protected WebSocket doWebSocketConnect(HttpServletRequest request, String protocol)    {
            return new ChatWebSocket();
        }

        class ChatWebSocket implements WebSocket    {

            Outbound _outbound;

            public void onConnect(Outbound outbound) {
                _outbound=outbound;
                _members.add(this);
            }

            public void onMessage(byte frame, byte[] data,int offset, int length) {}

            public void onMessage(byte frame, String data) {
/*                for (ChatWebSocket member : _members)  {
                    try  {
                        member._outbound.sendMessage(frame,data);
                    } catch(IOException e) {
                        Log.warn(e);
                    }
                }*/
            }

            @Override
            public void onFragment(boolean b, byte b2, byte[] bytes, int i, int i2) {

            }

            public void onDisconnect() {
                _members.remove(this);
            }
        }
}

