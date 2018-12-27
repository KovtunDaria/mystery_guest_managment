<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Отчёт</title>

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
                <h2>Отчёт о проверке</h2>
                <h4>кофейня на ${instructions.coffeeshop.address}   •   ${instructions.drink.name}</h4>
            </div>
        </div>
    </div>
</div>
<div class="block">
    <div class="container mb-5">
        <form method="post">
            <input type="hidden" name="inst_id" value="${instructions.id}">
            <input type="number" name="queue_minutes" placeholder="Минут в очереди" required>
            <br>
            <br>
            <input type="number" name="wait_minutes" placeholder="Минут ожидания напитка" required>
            <br>
            <br>
            <textarea name="barista_comment" maxlength="500" cols="30" rows="6" placeholder="Комментарий к баристе" required></textarea>
            <br>
            <textarea name="toilet_comment" maxlength="500" cols="30" rows="6" placeholder="Комментарий к туалету" required></textarea>
            <br>
            <textarea name="room_comment" maxlength="500" cols="30" rows="6" placeholder="Комментарий к помещению" required></textarea>
            <br>
            <textarea name="drink_comment" maxlength="500" cols="30" rows="6" placeholder="Комментарий к напитку" required></textarea>
            <br>
            <br>
            <input type="submit" name="submit">
        </form>
    </div>


    <div class="my-footer">
        <p>Все права защищены. Copyright &copy; 2018 Skuratov Coffee
            Roasters</p>
    </div>
</div>

</body>

</html>