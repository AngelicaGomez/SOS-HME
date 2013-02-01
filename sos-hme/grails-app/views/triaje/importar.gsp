<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta name="layout" content="basicrecord" />
    <title><g:message code="demographic.lista_candidatos.title" /></title>
  </head>
  <body>

  <div id="menu1">
  <ul>
    <a>Importar archivos</a>        
  </ul>
  </div>    
    
<div id="nivel1">
<div id="nivel2">
<div id="contenido">
<div class="form2">     
  
    <g:if test="${flash.message}">
      <div class="aviso">
      <ul><li>  <g:message code="${flash.message}" /></li></ul>
      </div>
    </g:if>
  
<g:form name="importUser" controller="triaje" action="importarArchivos" method="post" enctype="multipart/form-data">  
  <div class="fileinputs">
	<input type="file" class="file" id="fileName" name="fileName" style="width:500px;"/>
        <g:hiddenField name="episodioId" value="${episodioId}" />

	<div class="fakefile">
         
                <img src="${resource(dir:'images',file:'busqueda.PNG')}"/>
                
	</div>
        <g:each in="${nomArchivo}" var="archivo">
            <p>${archivo}</p>
        </g:each>        
  </div>  
<br/><br/>
<g:submitButton name="importar" value="Importar" class="boton_submit2"/>
<g:link controller="triaje" action="previewEnviarCaso" class="boton_submit2"><g:message code="Siguiente"  /></g:link>               
</g:form>   
  
</div></div></div></div>  
  </body>
</html>