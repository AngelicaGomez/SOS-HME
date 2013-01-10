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
    <d>Detalle</d>        
  </ul>
  </div>
      
<div id="nivel1">
    <div id="nivel2">
        <div id="contenido">
            <div class="form1"> 
              
              
<g:if test="${patient}">     
    <g:set var="name" value="${patient.identities.find{ it.purpose == 'PersonNamePatient'} }" />
    
      <table  class="tabla3">
         <tbody>
            <p>DATOS DEL PACIENTE </p>
            <tr>
               <td valign="top"><label for="nombre"><g:message code="nombreYApellido" default="Nombre y Apellido:" /></label></td>
               <td valign="top">${name.primerNombre} ${name.segundoNombre} ${name.primerApellido} ${name.segundoApellido}</td>
            </tr>
            <tr>
               <td valign="top"><label for="ci"><g:message code="ci" default="Num. Cédula:" /></label></td>
               <td valign="top">${patient.ids[0].extension}</td>
            </tr>   
            <tr>
               <td valign="top"><label for="sexo"><g:message code="sexo" default="Sexo:" /></label></td>
               <td valign="top">${patient.sexo}</td>
            </tr>   
            <tr>
               <td valign="top"><label for="nacionalidad"><g:message code="nacionalidad" default="Nacionalidad:" /></label></td>
                   <g:if test="${name.nacionalidad.nombre == 'Venezuela'}">
                         <g:if test="${patient.sexo == 'Masculino'}">
                             <td valign="top"><g:message code="venezolano" default="Venezolano"/></td>
                         </g:if>
                         <g:else>
                           <td valign="top"><g:message code="venezolana" default="Venezolana"/></td>
                         </g:else>                 
                      </g:if>
                      <g:else>
                         <g:if test="${patient.sexo == 'Masculino'}">
                             <td valign="top"><g:message code="extranjero" default="Extranjero"/></td>
                         </g:if>
                         <g:else>
                           <td valign="top"><g:message code="extranjera" default="Extranjera"/></td>
                         </g:else>  
                      </g:else>
           </tr>   
            <tr>
               <td valign="top"><label for="fecnaNacimiento"><g:message code="fecnaNacimiento" default="Fecha de Nacimiento:" /></label></td>
               <td valign="top"><g:formatDate format="dd-MM-yyyy" date="${patient?.fechaNacimiento}"/></td>
            </tr>            
         </tbody>
      </table>              
</g:if> 
              
<p style="clear:both">&nbsp;</p>
<p style="clear:both">&nbsp;</p>

      <table class="tabla2">
          <tbody>
          <p>DATOS DEL CASO </p>            
            <tr>
               <td valign="top"><label for="id"><g:message code="id" default="Id del caso:" /></label></td>
               <td valign="top">${episodioId}</td>
            </tr>
            <tr>
               <td valign="top"><label for="idPaciente"><g:message code="idPaciente" default="Id del Paciente:" /></label></td>
               <td valign="top">${patient.id.toString()}</td>
            </tr>   
            <tr>
               <td valign="top"><label for="descripcion"><g:message code="descripcion" default="Enfermedad Actual:" /></label></td>
               <td valign="top">${descripcionCaso}</td>
            </tr>             
         </tbody>
      </table>   

<p style="clear:both">&nbsp;</p>
<p style="clear:both">&nbsp;</p>

      <table class="tabla2">
          <tbody>
          <p>ESPECIALIDADES </p>            
            <tr>
                <td valign="top">
                    <label for="especialidad"><g:message code="Especialidad" default="Especialidad" /></label>
                </td>
                <td valign="top">
                    <g:select  style="width:250px" name="especialidad" noSelection="['':'Seleccione']" from="${esp}" value="${esp}"/>
                </td>
            </tr>            
         </tbody>
      </table>   
              
<p style="clear:both">&nbsp;</p>
              
            </div>
        </div>
    </div>
</div>    
    
  </body>
</html>