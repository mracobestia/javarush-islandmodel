# javarush-islandmodel
Модель жизни острова (v1.1)
========================
Краткое описание
-------------------------
Данная программа моделирует заданное пользователем количество дней жизни животных и растений на острове установленных размеров.
Животные острова могут:
- есть растения и/или других животных (если в их локации есть подходящая еда),
- передвигаться (в соседние локации),
- размножаться (при наличии пары в их локации),
- умирать от голода или быть съеденными (данная функция будет реализована в v1.2).

Растения острова:
- восполняются в локациях в начале каждого дня

После запуска приложения происходит автоматическое первоначальное распределение животных по клеткам острова.
После этого в каждый из дней:
- Растет трава
- Существующие животные перемещаются по полю
- Существующие животные пробуют поесть 
- Существующие животные размножаются

Статистика за день записывается в отдельный файл с расширением .txt в указанный пользователем перед началом игры каталог.
Статистика имеет вид:

*Position 1:1*

*Class Goat: 4*

*Class Eagle: 19*

*Class Herb: 47*


Запуск проекта
-------------------------
В консоли запустить:
$ java -jar ...\build\javarush-islandmodel.jar

Ограничения
------------------------
- В текущей v1.1 все животные и растения делают доступные им действия последовательно, в один поток.
- Настройки жизни острова, кроме количества дней и каталога для выгрузки статистики в v1.1 строго заданы и не могут быть изменены пользователем.
- Животные в v1.1 не умирают

Краткое описание классов
------------------------
В корневом пакете проекта `com.javarush.island.model` находится класс Main, содержащий в себе точку входа в приложение.

В пакете `com.javarush.island.model.programinterface` содержится класс GameInterface, в котором описана логика консольного интерфейса.

В пакете `com.javarush.island.model.settings` содержится класс Settings, в котором заданы настройки для работы приложения.

В пакете `com.javarush.island.model.common` содержатся базовые классы для игры: поле, клетка, базовый класс для животных и растений.

В пакете `com.javarush.island.model.animals` содержатся классы, объектами которых являются животные, населяющие остров.

В пакете `com.javarush.island.model.plants` содержатся классы, объектами которых являются растения, произрастающие на острове.