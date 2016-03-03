<!DOCTYPE html>
<html>
<head>
</head>
<body>
<div class="jumbotron text-center">
  <div class="container">
      <h3>Listas de valores</h3>
      <table border="1">
        <tr>
            <td>listEstimatedProxySize</td>
            <td>listPlanAddedModifiedSize</td>
            <td>listActualAddedModifiedSize</td>
            <td>listActualDevelopmentHour</td>
        </tr>
        <tr>
            <td>
                <#list listEstimatedProxySize as l>
                <p>${l}
                </#list>
            </td>
            <td>
                <#list listPlanAddedModifiedSize as l>
                <p>${l}
                </#list>
            </td>
            <td>
                <#list listActualAddedModifiedSize as l>
                <p>${l}
                </#list>
            </td>
            <td>
                <#list listActualDevelopmentHour as l>
                <p>${l}
                </#list>
            </td>
        </tr>
      </table>
      </br>
        <h4>Resultado prueba 1</h4>
        ${test1}

      </br>
        <h4>Resultado prueba 2</h4>
        ${test2}

      </br>
        <h4>Resultado prueba 3</h4>
        ${test3}

      </br>
        <h4>Resultado prueba 4</h4>
        ${test4}
      </br>
      </br>
 </div>
</div>
</body>
</html>
