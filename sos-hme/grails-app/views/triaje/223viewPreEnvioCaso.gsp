
<%@ page import="authorization.LoginAuth" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'loginAuth.label', default: 'LoginAuth')}" />
        <title><g:message code="loginAuth.user.show" args="[entityName]" /></title>
    </head>
    <body>

        <div class="body">
   
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>           
                      
                    
            <tr>
               <td valign="top" class="name"><g:message code="id" default="Id del caso" />:</td>
               <td valign="top" class="value">${episodioId}</td>
            </tr> 
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
          
                 <g:form>
                    <g:hiddenField name="episodioId" value="${episodioId}" />
                    <span class="button"><g:actionSubmit action="enviarCaso" value="${message(code: 'enviarCaso', default: 'Enviar Cso')}" /></span>
                 </g:form>
                
            </div>
        </div>
          
    </body>
</html>
