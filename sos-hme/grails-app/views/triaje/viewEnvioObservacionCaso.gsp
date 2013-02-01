<%@ page import="org.codehaus.groovy.grails.commons.ApplicationHolder" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="converters.DateConverter" %>
<%
  // Formateador para las fechas
  SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
%>
<html>
  <head>
    <meta name="layout" content="basicrecord" />
    <title><g:message code="demographic.lista_candidatos.title" /></title>
    
  </head>
  <body>

  <div id="menu1">
  <ul>
    <d></d>        
  </ul>
  </div>
      

<div id="nivel1">
    <div id="nivel2">

      <span class="obligatorio">&nbsp;*</span> Campos Obligatorios   
      <g:form>
        <div id="contenido">
            <div class="form2">         
      <table class="tabla2">
          <tbody>
          <p>DATOS DEL CASO </p>    
          
            <tr>
               <td><label for="id"><g:message code="id" default="Caso num:" /></label></td>
               <td>${id}</td>
            </tr>  
         
          <tr>
              <td><label for="observacion"><g:message code="observacion" default="Observacion:" /></label></td>
              <td><g:textArea style="width: 350px; height: 250px" name="observacion"/><span class="obligatorio">&nbsp;*</span></td>
          </tr>  
         </tbody>
      </table>   

<p style="clear:both">&nbsp;</p>

                     <g:hiddenField name="id" value="${id}" />
                    
                    <g:actionSubmit action="enviarObservacion" value="Enviar observacion" class="boton_submit2" onclick="return confirm('${message(code: 'default.button.send.sos.confirm.message', default: 'Esta seguro?')}');"/>
                 
<g:link controller="triaje" action="viewSeguimientoCaso" class="boton_submit2"><g:message code="trauma.show.action.back"  /></g:link>                    
            </div>
        </div>
</g:form>    
<p style="clear:both">&nbsp;</p>
</div>
</div>    
  
  </body>
</html>