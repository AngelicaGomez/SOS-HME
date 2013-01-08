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
		<p>Exito</p>
                <p>${id}</p>
            </g:if>
            <h1>${message}</h1>  
            <p>episodio: ${episodioId}</p>
            <p>patient: ${patient}</p>
            
            <!-- hce.core.composition.Composition -->
            <p>comp: ${comp} (${comp.class})</p> 
            <p>Composicion Content: ${comp.content} (${comp.content.class})</p>
            <p>Enfermedad Actual: ${comp.content[2]} (${comp.content[2].class})</p>
            <p>Observation Data: ${comp.content.data} (${comp.content.data.class})</p>
            <p>composicion context: ${comp.context} (${comp.context.class})</p>
            <p>Prueba Observacion: ${comp.context.otherContext.item.value.value} (${comp.context.otherContext.item.value.value.class})</p>
            <p>idPaciente: ${patient.id}</p>
            <p>persona: ${persona}</p>
            <p>compositions: ${compositions}</p>

<g:if test="${patient}">
     
    <g:set var="name" value="${patient.identities.find{ it.purpose == 'PersonNamePatient'} }" />
    <g:set var="person_id" value="${patient.id}" />
    
    <!-- PersonNamePatient -->
    <p>${name} (${name.class})</p>
    
    <!-- String -->
    <p>Primer Nombre: ${name.primerNombre} (${name.primerNombre.class})</p> 
    <p>Segundo Nombre: ${name.segundoNombre} (${name.segundoNombre.class})</p>
    <p>Primer Apellido: ${name.primerApellido} (${name.primerApellido.class})</p>
    <p>Segundo Apellido: ${name.segundoApellido} (${name.segundoApellido.class})</p>
    
    <p>Sexo: ${patient.sexo} (${patient.sexo.class})</p>
    
    <p>Nacionalidad: ${name.nacionalidad.nombre} (${name.nacionalidad.nombre.class})</p>
    
    <!-- java.util.ArrayList -->
    <p>Cedula: ${patient.ids[0].extension} (${patient.ids[0].extension.class})</p>
    
    <!-- java.sql.Timestampt -->
    <p>Fecha Nacimiento: <g:if test="${patient?.fechaNacimiento}">${patient.fechaNacimiento}</g:if> (${patient.fechaNacimiento.class})</p>
    
    <!-- <g:link controller="demographic" action="show" id="${patient.id}">-->
    <!--No necesito la foto actualmente -->
    <!--<p><span class="etiqueta">Ids:</span>  <g:render template="UIDBasedID" collection="${patient.ids}" var="id" /></p>
    <h1>Fecha Nac.:<g:if test="${patient?.fechaNacimiento}"><g:formatDate date="${patient.fechaNacimiento}" format="${g.message(code: 'default.date.format1')}" /></g:if></h1>
    
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
    -->
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