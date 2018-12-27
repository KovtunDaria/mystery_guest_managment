<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Личный кабинет</title>

    <!-- Bootstrap 4 CSS -->
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

    <!-- MDC Web CSS -->
    <link rel="stylesheet"
          href="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css">

    <link rel="stylesheet" href="/css/style.min.css?v=2">
</head>

<body>
<div class="header">
    <a href="/logout" class="float-right mr-5 py-1">
        Выход
    </a>
</div>
<div class="block block-light block-wide pt-5">
    <div class="container">
        <div class="row">
            <div class="col-8">
                <h2>Добро пожаловать, ${guest.name}!</h2>
                <#if guest.card.activated>
                    <h4>карта #${guest.card.id}</h4>
                <#else>
                    <h4>карта не выдана</h4>
                </#if>
            </div>
            <#if guest.card.activated>
                <div class="col-4">
                    <h1>${guest.card.balance}</h1>
                    <h4>баллов на счету</h4>
                </div>
            </#if>
        </div>
    </div>
</div>
<div class="block">
    <div class="container mb-5">
        <h3 class="mb-4">Задания</h3>
        <div class="d-flex flex-row justify-content-start align-items-start flex-wrap">
            <#list guest.instructions as inst>
            <#--<div class="col-4 mb-4">-->
                <div class="card card-${inst.status.name()} m-2">
                    <div class="card-header">
                        ${inst.status}
                    </div>
                    <div class="card-body">
                        <h4>${inst.drink.name}</h4>
                        <h5>${inst.coffeeshop.address}</h5>
                    </div>
                    <div class="card-footer">
                        <#switch inst.status.name()>
                            <#case "free">
                                <a href="/take?id=${inst.id}"><strong>Взять</strong></a>
                                <a href="/reject?id=${inst.id}">Отказаться</a>
                                <#break>
                            <#case "taken">
                                <a href="/report?id=${inst.id}"><strong>Составить отчёт</strong></a>
                                <a href="/reject?id=${inst.id}">Отказаться</a>
                                <#break>
                        </#switch>
                    </div>
                </div>
            <#--</div>-->
            </#list>
        </div>
    </div>


    <div class="my-footer">
        <p>Все права защищены. Copyright &copy; 2018 Skuratov Coffee
            Roasters</p>
    </div>
</div>

</body>

</html>