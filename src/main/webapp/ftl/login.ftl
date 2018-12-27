<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Вход</title>

    <!-- Bootstrap 4 CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

    <!-- MDC Web CSS -->
    <link rel="stylesheet" href="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css">

    <link rel="stylesheet" href="/css/style.min.css?v=2">
</head>

<body>
<div class="header">

</div>

<div class="block block-light">
    <div class="container text-center">
        <h1 class="mb-5">Вход</h1>
        <form method="post" action="/login">
        <div class="row justify-content-center mb-5">
            <div class="col-8">
                <div class="mdc-text-field mdc-text-field--outlined field-light w-100 mb-4">
                    <input type="email" id="user_email" name="email" class="mdc-text-field__input">
                    <div class="mdc-notched-outline">
                        <div class="mdc-notched-outline__leading"></div>
                        <div class="mdc-notched-outline__notch">
                            <label for="user_email" class="mdc-floating-label">E-Mail</label>
                        </div>
                        <div class="mdc-notched-outline__trailing"></div>
                    </div>
                </div>
                <div class="mdc-text-field mdc-text-field--outlined field-light w-100">
                    <input type="password" id="user_password" name="password" class="mdc-text-field__input">
                    <div class="mdc-notched-outline">
                        <div class="mdc-notched-outline__leading"></div>
                        <div class="mdc-notched-outline__notch">
                            <label for="user_password" class="mdc-floating-label">Пароль</label>
                        </div>
                        <div class="mdc-notched-outline__trailing"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="text-center mb-2">
            <button type="submit" class="button button-dark">Войти</button>
        </div>
        </form>
        <div class="text-center">
            <a href="/index" class="block-link-small">Зарегистрироваться?</a>
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