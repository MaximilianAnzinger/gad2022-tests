# Anleitung

Um die **FiboHeapExtractMinTests** Tests zu benutzen, darf in der extractMin()-Methode nicht die consolidate()-Methode aufgerufen werden. Also einfach zum Testen den Methodenaufruf auskommentieren.

## Beispiel:

```java
...

consolidate();

...
```

Abändern zu:

```java
...

// consolidate();

...
```
