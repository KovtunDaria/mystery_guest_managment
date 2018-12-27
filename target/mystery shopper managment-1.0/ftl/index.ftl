<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Тайный гость Skuratov</title>

    <!-- Bootstrap 4 CSS -->
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

    <!-- MDC Web CSS -->
    <link rel="stylesheet" href="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css">

    <link rel="stylesheet" href="/css/style.min.css?v=2">
</head>
<body>
<div class="main-header">
    <p class="login-button"><a href="/login">Вход</a></p>
</div>
<div class="block block-light block-wide">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <h1>Строим кофейню мечты. Вместе.</h1>
                <p>
                    Стань тайным гостем Skuratov Coffee Roasters, оценивай сервис и
                    напитки, получай вознаграждения в виде баллов, которыми можно
                    оплачивать следующие заказы
                </p></div>
            <div class="col-md-4"></div>
        </div>
    </div>
</div>
<div class="block block-dark">
    <div class="container text-center">
        <h1 class="mb-5">Заполни анкету прямо сейчас</h1>
        <form action="/register" method="post">
        <div class="row justify-content-center mb-5">
            <div class="col-3">
                <div class="mdc-text-field mdc-text-field--outlined field-dark">
                    <input type="text" id="user_name" name="name" class="mdc-text-field__input">
                    <div class="mdc-notched-outline">
                        <div class="mdc-notched-outline__leading"></div>
                        <div class="mdc-notched-outline__notch">
                            <label for="user_name" class="mdc-floating-label">Имя</label>
                        </div>
                        <div class="mdc-notched-outline__trailing"></div>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <div class="mdc-text-field mdc-text-field--outlined field-dark w-100">
                    <input type="email" id="user_email" name="email" class="mdc-text-field__input">
                    <div class="mdc-notched-outline">
                        <div class="mdc-notched-outline__leading"></div>
                        <div class="mdc-notched-outline__notch">
                            <label for="user_email" class="mdc-floating-label">E-mail</label>
                        </div>
                        <div class="mdc-notched-outline__trailing"></div>
                    </div>
                </div>
            </div>
            <div class="col-3">
                <div class="mdc-text-field mdc-text-field--outlined field-dark">
                    <input type="text" id="user_city" name="city" class="mdc-text-field__input">
                    <div class="mdc-notched-outline">
                        <div class="mdc-notched-outline__leading"></div>
                        <div class="mdc-notched-outline__notch">
                            <label for="user_city" class="mdc-floating-label">Город</label>
                        </div>
                        <div class="mdc-notched-outline__trailing"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="text-center mb-2">
            <button type="submit" class="button button-dark">Отправить заявку</button>
        </div>
        </form>
        <div class="text-center">
            <a href="#" class="block-link-small">Уже тайный гость?</a>
        </div>
    </div>
</div>
<div class="my-footer">
    <p>Все права защищены. Copyright &copy; 2018 Skuratov Coffee Roasters</p>
</div>

<!-- MDC Web JavaScript -->
<script src="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.js"></script>
<!-- Instantiate MDC components -->
<script>
    for (elem of document.querySelectorAll('.mdc-text-field')) {
        mdc.textField.MDCTextField.attachTo(elem);
    }
</script>
</body>
</html>