/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2012 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package org.agoncal.book.javaee7.chapter20;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
@LocalBean
public class JavaEESyncReceiverOld {

    @Resource(lookup = "java:global/jms/chapter20ConnectionFactory")
    ConnectionFactory connectionFactory;
    
    @Resource(lookup = "java:global/jms/chapter20Queue")
    Queue chapter20Queue;
    
    // GlassFish 4.0 currently uses Java SE 6, so this example does not make use of the Java SE 7 AutoCloseable API. 

    public String receiveMessageOld() {
        Connection connection = null;
        try {
            try {
                connection = connectionFactory.createConnection();
                connection.start();
                Session session = connection.createSession();
                MessageConsumer messageConsumer = session.createConsumer(chapter20Queue);
                TextMessage textMessage = (TextMessage) messageConsumer.receive(1000);
                if (textMessage==null){
                    return "Received null";
                } else {
                    return "Received "+textMessage.getText();
                }
            } finally {
                connection.close();
            }
        } catch (JMSException ex) {
            Logger.getLogger(JavaEESyncReceiverOld.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
