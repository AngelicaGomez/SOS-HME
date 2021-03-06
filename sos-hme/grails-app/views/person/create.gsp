

<%@ page import="demographic.party.Person" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="layout" content="main" />
  <g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
  <title><g:message code="default.create.label" args="[entityName]" /></title>



</head>
<body>

  <div class="body">
    <h2><g:message code="default.create.label" args="[entityName]" /></h2>
    <g:if test="${flash.message}">
      <div class="message">${flash.message}</div>
    </g:if>
   <g:hasErrors bean="${personInstance}">
            <div class="errors">
                <g:renderErrors bean="${personInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:hasErrors bean="${personNameUserInstance}">
               <%-- <g:eachError><p>${it.defaultMessage}</p></g:eachError>--%>
              <div class="errors">
                <g:renderErrors bean="${personNameUserInstance}" as="list" />
              </div>  
            </g:hasErrors>
    <g:form action="save" >
      <div class="dialog">
        <table>
          <tbody>

    <%--      <tr class="prop">
              <td valign="top" class="name">
                <label for="identities">
                  <g:message code="person.copy.label" default="Desde pacientes"/>:
                </label>

              </td>
              <td valign="top" class="value ${hasErrors(bean: personInstance, field: 'identities', 'errors')}">

          <g:link controller="person" action="find">
${message(code: 'person.copy.label', args: [message(code: 'role.label', default: 'PersonName')])}

          </g:link>

          </td>
          </tr>
--%>
         
            
          <input name="role" type="hidden" value="${role}" />
            <tr class="prop">
            <td valign="top" class="name">
              <label for="identificador"><g:message code="person.id.label" /></label>:
            </td>
            <td valign="top" class="name">
          <g:select name="root"  from="${tiposIds}" optionKey="codigo" optionValue="nombreCorto" />
          <g:textField name="extension" value="${extension}" />
          </td>


          </tr>
            
          <tr class="prop">
            <td valign="top" class="name">
              <label for="primerNombre"><g:message code="personNameUser.primerNombre.label" default="Primer Nombre" />:</label>
            </td>
            <td valign="top" class="value ${hasErrors(bean: personNameUserInstance, field: 'primerNombre', 'errors')}">
          <g:textField name="primerNombre" value="${personNameUserInstance?.primerNombre}" />
          </td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name">
              <label for="segundoNombre"><g:message code="personNameUser.segundoNombre.label" default="Segundo Nombre" />:</label>
            </td>
            <td valign="top" class="value ${hasErrors(bean: personNameUserInstance, field: 'segundoNombre', 'errors')}">
          <g:textField name="segundoNombre" value="${personNameUserInstance?.segundoNombre}" />
          </td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name">
              <label for="primerApellido"><g:message code="personNameUser.primerApellido.label" default="Primer Apellido" />:</label>
            </td>
            <td valign="top" class="value ${hasErrors(bean: personNameUserInstance, field: 'primerApellido', 'errors')}">
          <g:textField name="primerApellido" value="${personNameUserInstance?.primerApellido}" />
          </td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name">
              <label for="segundoApellido"><g:message code="personNameUser.segundoApellido.label" default="Segundo Apellido" />:</label>
            </td>
            <td valign="top" class="value ${hasErrors(bean: personNameUserInstance, field: 'segundoApellido', 'errors')}">
          <g:textField name="segundoApellido" value="${personNameUserInstance?.segundoApellido}" />
          </td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name">
              <label for="telfhabitacion"><g:message code="personNameUser.telfhabitacion.label" default="Telfhabitacion" />:</label>
            </td>
            <td valign="top" class="value ${hasErrors(bean: personNameUserInstance, field: 'telfhabitacion', 'errors')}">
          <g:textField name="telfhabitacion" value="${personNameUserInstance?.telfhabitacion}" />
          </td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name">
              <label for="telfcelular"><g:message code="personNameUser.telfcelular.label" default="Telfcelular" />:</label>
            </td>
            <td valign="top" class="value ${hasErrors(bean: personNameUserInstance, field: 'telfcelular', 'errors')}">
          <g:textField name="telfcelular" value="${personNameUserInstance?.telfcelular}" />
          </td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name">
              <label for="email"><g:message code="personNameUser.email.label" default="Email" />:</label>
            </td>
            <td valign="top" class="value ${hasErrors(bean: personInstance, field: 'email', 'errors')}">
          <g:textField name="email" value="${personInstance?.email}" />
          </td>
          </tr>
          <tr class="prop">
            <td valign="top" class="name">
              <label for="fechaNacimiento"><g:message code="person.fechaNacimiento.label" default="Fecha de nacimiento" /></label>:
            </td>
            <td valign="top" class="value ${hasErrors(bean: personInstance, field: 'fechaNacimiento', 'errors')}">
          <g:datePicker name="fechaNacimiento" precision="day" value="${personInstance?.fechaNacimiento}" default="none" noSelection="['': '']" />
          </td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name">
              <label for="sexo"><g:message code="person.sexo.label" default="Sexo" /></label>:
            </td>
           
            <td valign="top" class="value ${hasErrors(bean: personInstance, field: 'sexo', 'errors')}">
          <g:select name="sexo" from="${Person.getSexCodes().asList()}"  noSelection="${['':'']}" value="${personInstance?.sexo}"  />
          </td>
          </tr>

        <%--  <tr class="prop">
            <td valign="top" class="name">
              <label for="roles"><g:message code="person.roles.label" default="Roles" /></label>
            </td>
            <td valign="top" class="value ${hasErrors(bean: personInstance, field: 'roles', 'errors')}">

              <ul>
                <g:each in="${personInstance.roles}" var="r">
                  <li><g:link controller="role" action="edit" params="['id': r.id, 'person.id': personInstance?.id]">${r?.type}</g:link></li>
                </g:each>
              </ul><br>
          <g:link controller="role" action="create" params="['person.id': personInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'role.label', default: 'Role')])}</g:link>

          </td>
          </tr>--%>

          


          </tbody>
        </table>
        
      </div>
      
      <div class="buttons">
       <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
       <span class="button"><g:link class="list" action="list" params="[role: role]"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        
      </div>
    </g:form>
  </div>
</body>
</html>
