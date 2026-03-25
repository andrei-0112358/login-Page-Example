# Login-Registration-Seite-Muster (Java)

## Beschreibung
Dieses Projekt ist ein einfaches Beispiel dafür, wie man theoretisch eine Benutzerregistrierung und einen Login implementieren kann. Eine echte Datenbank ist hier nicht vorhanden, sie wird nur hypothetisch angenommen.

## Regeln
Der Benutzer gibt einen Login und ein Passwort ein. Wenn der Benutzer bereits existiert, wird ein Login durchgeführt. Wenn der Benutzer nicht existiert, wird ein neuer Benutzer erstellt.

## Funktionsweise
Das Programm stellt eine Verbindung zu einer hypothetischen Datenbank her und überprüft, ob ein Benutzer mit dem angegebenen Login existiert. Falls ja, wird eine Anmeldung simuliert. Falls nicht, wird ein neuer Benutzer in die Datenbank eingefügt. Das Beispiel zeigt nur die grundlegende Struktur und ersetzt keine echte sichere Implementierung.

## Ablauf
Benutzer gibt Login und Passwort ein. Programm prüft, ob der Benutzer existiert. Falls ja, wird Login ausgeführt. Falls nein, wird ein neuer Benutzer erstellt.

## Ausführen
javac com/mycompany/loginexample/LoginExample.java java com.mycompany.loginexample.LoginExample

## Voraussetzungen
Java JDK 8 oder höher
