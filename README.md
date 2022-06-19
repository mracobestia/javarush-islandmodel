# javarush-islandmodel
Модель жизни острова (v1.1)
========================
Краткое описание
-------------------------
Данная программа моделирует заданное пользователем количество дней жизни животных и растений на острове установленных размеров (100х20) .
Животные острова могут:
- есть растения и/или других животных (если в их локации есть подходящая еда),
- передвигаться (в соседние локации),
- размножаться (при наличии пары в их локации),
- умирать от голода или быть съеденными.

Растения острова:
- восполняются в локациях в начале каждого дня

После запуска приложения происходит автоматическое первоначальное распределение животных по клеткам острова.
После этого в каждый из дней:
- Растет трава
- Существующие животные перемещаются по полю
- Существующие животные пробуют поесть 
- Существующие животные размножаются

Статистика за день записывается в отдельные файлы для каждого дня с расширением .txt в указанный пользователем перед началом игры каталог.
Статистика имеет вид:

*After travelling:*

*Total number of animals by classes:*

*Class  Boar: 34*

*Class  Eagle: 16*

*Total number of animals: 50*


Запуск проекта
-------------------------
В консоли запустить:
$ java -jar ...\build\javarush-islandmodel.jar

Ограничения
------------------------
Все настройки игры предопределены. Пользователь на старте указывает только количество игровых дней и каталог для сохранения файлов статистики.

Краткое описание классов
------------------------
В корневом пакете проекта `com.javarush.island.model` находится класс Main, содержащий в себе точку входа в приложение.

В пакете `com.javarush.island.model.programinterface` содержится класс GameInterface, в котором описана логика консольного интерфейса.

В пакете `com.javarush.island.model.settings` содержится класс Settings, в котором заданы настройки для работы приложения.

В пакете `com.javarush.island.model.common` содержатся базовые классы для игры: поле, клетка, базовый класс для животных и растений.

В пакете `com.javarush.island.model.animals` содержатся классы, объектами которых являются животные, населяющие остров.

В пакете `com.javarush.island.model.plants` содержатся классы, объектами которых являются растения, произрастающие на острове.