<html>
  <body>
  <h1>Listar template</h1>
      <g:if test="${flash.message}">
      <div class="aviso">
      <ul><li>  <g:message code="${flash.message}" /></li></ul>
      </div>
    </g:if>
  <ul>
    <g:each in="${templateNames}" var="template">
      <li><g:link action="generarTemplate" params="[templateId:template]">${template}</g:link></li>
    </g:each>
  </ul>
  
  </body>
</html>