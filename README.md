# Симуляция
Проект создан на основе технических характеристик, описанных в [этом курсе](https://zhukovsd.github.io/java-backend-learning-course/projects/simulation/)

---
## Описание проекта
* Реализована симуляция 2D мира - матрица NxM, где каждое существо или объект занимают одну клетку целиком
* Игра имеет консольный интерфейс
* Каждый ход все животные совершают по 1 действию - приблизиться к цели или съесть её (в случае с хищниками добавлено также действие атаки)
* Животные двигаются только по пустым ячейкам
* Симуляция продолжается, пока игрок не остановит/поставит на паузу игру
* Размеры карты задаются при создании экземпляра класса Simulation в классе Main
---
### Пример работы программы
![изображение](https://github.com/user-attachments/assets/565cfb61-9360-42d8-83ad-3d9bd7605ea4)

