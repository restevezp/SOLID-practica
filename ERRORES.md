
## PRINCIPIOS SOLID NO CUMPLIDOS

PRINCIPIO DE SEGREGACIÓN DE INTERFACES: 

No se cumplía ya que la interfaz FileSystemItem estaba siendo usada por Directory, File y FileSystemItemBase cuando contiene métodos innecesarios para alguna de las clases.

He creado 3 interfaces en las que he intentado separar los métodos esenciales para cada uno de ellos.

PRINCIPIO DE RESPONSABILIDAD UNICA:

Dentro de File podemos observar que además de las tareas normales que pueden derivar de la responsabilidad de la clase File nos encontramos con 2 métodos para convertir archivos de sonido de un formato a otro. Estos métodos los he pasado a FileManager por si en algún momento se deciden utilizar y liberado de la clase File.

PINCIPIO DE INVERSION DE DEPENDENCIAS:

Al crear las distintas interfaces usadas para File, Directory y FileSystemItemBase se consigue aislar el código de alto nivel de las implementaciones de bajo nivel.





## CAMBIOS REALIZADOS

- se modifica int getSize(): para que nos deuvelva el tamaño de  los ficheros y directorios en vez de una excepción.


