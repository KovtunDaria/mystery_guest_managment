package ru.itis.mystery_shopper_managment.models;

public enum Status {
    free("Новое задание"),
    taken("Ждёт отчёта"),
    awaiting("На проверке"),
    completed("Завершено"),
    failed("Провалено");
    private String stringValue;

    Status(String stringValue) {
        this.stringValue = stringValue;
    }

    @Override
    public String toString() {
        return stringValue;
    }
}
