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
        <li>
        <g:link controller="records" action="list"><g:message code="records.action.list" /></g:link>
        </li>
        <li>
        <g:link controller="demographic" action="admisionPaciente"><g:message code="demographic.action.admisionPaciente" /></g:link>
        </li>

        <li>
        <g:link controller="reportes"><g:message code="reportes.Reportes"/></g:link>
        </li>
        
        <li>
        <g:link controller="triaje" action="viewSeguimientoCaso" class="selected"><g:message code="Seguimiento del Caso"/></g:link>
        </li>

        <li>
        <g:link controller="triaje" action="viewCasoResuelto"><g:message code="Casos resueltos"/></g:link>
        </li>
      </ul>
    </div>
    
<g:form>
<div id="nivel1">
    <div id="nivel2">
        <div id="contenido">
            <div class="form1"> 
          <table width="100%" border="0" cellpadding="0" cellspacing="0" id="listrecords" class="tabla1">
                <tr>
                  <th class="threcords"><g:message code="idCasoSOS.label" default="Caso" /></th>
                  <th class="threcords"><g:message code="opinion.label" default="Solución al caso" /></th>
                  <th class="threcords"></th>
                  <th class="threcords"><g:message code="archivos.label" default="Archivos" /></th>
                  <!-- 
                  <th class="threcords"><g:message code="nombreResponsable.label" default="Médico responsable" /></th>
                 <th class="threcords"><g:message code="colegioDeMedico.label" default="Num. Colegio de Médicos" /></th>                      
                  <th class="threcords"><g:message code="ministerioDeSalud.label" default="Num. Min. de Salud" /></th>    -->
                </tr>
              <g:each in="${casoMostrado}" status="i" var="thisCasoMostrado">
                <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

                  <%
                  thisOpiniones = thisCasoMostrado.opiniones
                  thisArchivos = thisCasoMostrado.archivos
                  thisDoctor = thisCasoMostrado.opiniones.medicoOpinion
                  %>
                    <td style="width:60px;">${thisCasoMostrado.idCasoSOS}</td>
                    
                    <td style="width:340px;" class="pJustifica"><g:encodeAs codec="NL2BR">
                        <g:each in="${thisCasoMostrado?.opiniones}" var="opiniones">                                  
                          ${opiniones.cuerpoOpinion} <br/>                       
                          Fecha de emisión: ${opiniones.fechaOpinion} <br/>
                          Médico responsable: ${opiniones.medicoOpinion.nombre} ${opiniones.medicoOpinion.apellido}
                     
                        </g:each>    
                    </g:encodeAs></td>                    
                        
                    <td style="width:10px;"></td>
                    <td style="width:120px;">
                        <g:each in="${thisArchivos}" var="archivos">                                  
                          <li><g:link controller="triaje" action="showArchivoSeleccionado" id="${archivos?.nombre}" target="_blank">${archivos?.nombre}</g:link></li>
                        </g:each>                            
                    </td>                     

                </tr>
                <tr><td><br/></td></tr>
            </g:each>
            </table>   

            </div>
        </div>   
    </div>
</div>    
</g:form>
  
  </body>
</html>