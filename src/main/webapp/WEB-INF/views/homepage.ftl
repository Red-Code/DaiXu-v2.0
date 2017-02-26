<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
Hello ${name}
<div>
    <#list adv_obj as adv>
        img : ${adv.advImg}<br/>
        url : ${adv.advUrl}
    </#list>
</div>
<div>
    one_img:${one_adv.advImg}<br/>
    one_url:${one_adv.advUrl}
</div>
</body>
</html>