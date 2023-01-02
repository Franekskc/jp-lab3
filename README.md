# jp-lab3
program na lab3 - uciekający przycisk + canvas

Po włączeniu programu pojawia się okno z przyciskiem. Przycisk będzię uciekał od kursora, chyba że najedzie się na niego powoli od lewej strony.
Po kliknięciu pojawi sie okno weryfikacji. Po wpisaniu hasła "123" pojawi się kolejne okno kanwy.
W oknie kanwy znajduje sie toolbar w ktorym można wybrać (myszką lub klawiaturą) figurę do narysowania lub kolor.
Po wybraniu figury przez 5 sekund można tworzyć jej rysunek na kanwie poprzez kliknięcie myszą.

Klasy:
MainWindow, CanvasWindow, PasswordWindow - okna
RunningButton - uciekający przycisk
CanvasPanel - panel do rysowania
MyShape, MyRectangle, MyOval, MyTriangle, MyLine - kształty do rysowania
TimerThread - wątek timeout'u
