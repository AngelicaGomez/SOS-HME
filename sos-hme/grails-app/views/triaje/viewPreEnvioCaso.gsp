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
      
   
<g:form>
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
               <td valign="top"><label for="idPaciente"><g:message code="idPaciente" default="Id del Paciente:" /></label></td>
               <td valign="top">${patient.id}</td>
            </tr>           
            <tr>
               <td valign="top"><label for="id"><g:message code="id" default="Id del caso:" /></label></td>
               <td valign="top">${episodioId}</td>
            </tr>  
            <tr>
                <td valign="top"><label for="especialidad"><g:message code="Especialidad" default="Especialidad" /></label></td>
                <td valign="top"><g:select  style="width:250px" name="especialidad" noSelection="['':'Seleccione']" from="${esp}"/></td>
            </tr>            
            <tr>
               <td valign="top"><label for="descripcion"><g:message code="descripcion" default="Enfermedad Actual:" /></label></td>
               <td valign="top"><g:encodeAs codec="NL2BR">${descripcionCaso}</g:encodeAs></td>
            </tr>              
         </tbody>
      </table>   

<p style="clear:both">&nbsp;</p>
            </div>
        </div>
          
                    <g:hiddenField name="primerNombre" value="${name.primerNombre}" />
                    <g:hiddenField name="segundoNombre" value="${name.segundoNombre}" />
                    <g:hiddenField name="primerApellido" value="${name.primerApellido}" />
                    <g:hiddenField name="segundoApellido" value="${name.segundoApellido}" />
                    <g:hiddenField name="cedula" value="${patient.ids[0].extension}" />
                    <g:hiddenField name="sexo" value="${patient.sexo}" />
                    <g:hiddenField name="nacionalidad" value="${name.nacionalidad.nombre}" />
                    <g:hiddenField name="fechaNacimiento" value="${patient?.fechaNacimiento}" />
                    <g:hiddenField name="pacienteId" value="${patient.id}" />
                    <g:hiddenField name="episodioId" value="${episodioId}" />
                    <g:hiddenField name="descripcionCaso" value="${descripcionCaso}" />
                    
                    <g:actionSubmit action="enviarCaso" value="Enviar caso" class="boton1"/>
                 
    </div>
</div>    
</g:form>
  </body>
</html>