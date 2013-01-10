<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
            <g:if test="${id}">
		<p>Exito, Caso a enviar exitosamente</p>
            </g:if>
            <g:if test="${enfermedadActual==true}">
		<p>Caso SI puede ser enviado a SOS-TRIAJE</p>
            </g:if>
            <g:else>
                <p>Caso NO puede ser enviado a SOS-TRIAJE favor llenar el apartado de enfermedad actual</p>
            </g:else>
  
            <!-- String -->
            <p>ID DEL CASO: ${episodioId}</p>
            
            <!--java.lang.Long  (NO necesario)
            <p>ID DEL PACIENTE: ${patient.id}</p>-->
            
            <!-- String (NO necesario)-->
            <p>ID DEL PACIENTE: ${patient.id.toString()}</p>
            
            <!--demographic.party.Person (NO necesario)-->
            <p>PACIENTE: ${patient}</p>
            
            <!-- String -->
            <p>DESCRIPCION DEL CASO: ${descripcionCaso}</p>
            
<g:if test="${patient}">
     
    <g:set var="name" value="${patient.identities.find{ it.purpose == 'PersonNamePatient'} }" />
    <g:set var="person_id" value="${patient.id}" />
    
    <!-- demographic.identity.PersonNamePatient -->
    <p>NOMBRE COMPLETO DEL PACIENTE: ${name}</p>
    
    <!-- String -->
    <p>DETALLE DEL PACIENTE</p>
    <p>Primer Nombre: ${name.primerNombre}</p> 
    <p>Segundo Nombre: ${name.segundoNombre}</p>
    <p>Primer Apellido: ${name.primerApellido}</p>
    <p>Segundo Apellido: ${name.segundoApellido}</p>
    
    <!-- String -->
    <p>Sexo: ${patient.sexo}</p>
    
    <!-- String -->
    <p>Nacionalidad: ${name.nacionalidad.nombre}</p>
    
    <!-- java.util.ArrayList   (NO necesario)
    <p>Cedula: ${patient.ids.extension}</p>-->
    
    <!-- String -->
    <p>Cedula: ${patient.ids[0].extension}</p>
    
    <!-- java.sql.Timestampt 
    <p>Fecha Nacimiento: <g:if test="${patient?.fechaNacimiento}">${patient.fechaNacimiento}</g:if> (${patient.fechaNacimiento.class})</p>-->
    <p>Fecha Nacimiento:<g:formatDate format="dd-MM-yyyy" date="${patient?.fechaNacimiento}"/></p>
    
    <p>${patient.fechaNacimiento.toString()}</p>
    
    
    <!-- <g:link controller="demographic" action="show" id="${patient.id}">-->
    <!--
    <p><span class="etiqueta">Ids:</span>  <g:render template="UIDBasedID" collection="${patient.ids}" var="id" /></p>
    <p>Fecha Nac.:<g:if test="${patient?.fechaNacimiento}"><g:formatDate date="${patient.fechaNacimiento}" format="${g.message(code: 'default.date.format1')}" /></g:if></p>
    -->
    
    <g:if test="${!name || !name.foto || !name.tipofoto}">
          <g:if test="${patient.sexo=='Masculino'}">
                <img src="${createLinkTo(dir:"images", file:"man.png")}" style="width:52px; height: auto;" />
          </g:if>  
          <g:else>
                <img src="${createLinkTo(dir:"images", file:"woman.png")}" style="width:52px; height: auto;" />
          </g:else>
    </g:if>
    <g:else>
       <img src="${createLink(controller:"demographic", action: 'fotopaciente', params:[persona:patient.id])}" style="width:52px; height: auto;"/>
    </g:else>    
    
    <!--</g:link>-->
</g:if>

      <table>
          <tbody>
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
            
            
  </body>
</html>