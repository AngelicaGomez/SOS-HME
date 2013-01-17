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
        <g:link controller="triaje" action="viewCasoResuelto" class="selected"><g:message code="NUEVO"/></g:link>
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
                  <th class="threcords"><g:message code="fechaSolucion.label" default="Fecha de solución" /></th>
                  <th class="threcords"><g:message code="nombreResponsable.label" default="Médico responsable" /></th>
                  <th class="threcords"><g:message code="colegioDeMedico.label" default="Num. Colegio de Médicos" /></th>                      
                  <th class="threcords"><g:message code="ministerioDeSalud.label" default="Num. Min. de Salud" /></th>    
                </tr>
              <g:each in="${casoMostrado}" status="i" var="thisCasoResuelto">
                <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

                  <%
                  thisResponsable = thisCasoResuelto.responsable
                  %>
                    <td>${thisCasoResuelto.idCasoSOS}</td>
                    <td><g:encodeAs codec="NL2BR">${thisCasoResuelto.opinion} </g:encodeAs></td>                      
                    <td>${thisCasoResuelto.fechaSolucion}</td>
                    <td>${thisResponsable.nombre} ${thisResponsable.apellido}</td>
                    <g:if test="${thisResponsable?.colegioDeMedico==0}">
                        <td></td>
                    </g:if>
                    <g:else>
                        <td>${thisResponsable?.colegioDeMedico}</td>
                    </g:else>
                    <g:if test="${thisResponsable?.ministerioDeSalud==0}">
                        <td></td>
                    </g:if>
                    <g:else>
                        <td>${thisResponsable?.ministerioDeSalud}</td>
                    </g:else>
                </tr>
            </g:each>
            </table>   

            </div>
        </div>   
    </div>
</div>    
</g:form>
  
  </body>
</html>