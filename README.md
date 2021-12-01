# Aplicacion Mutantes

# Descripcion

La aplicacion detecta si es humano o es mutante, mediante su ADN.
Este ADN estara en una matriz y se detectara que es un mutante si tiene mas de una secuencia de 4 caracteres de forma oblicua, horizontal o vertical.

# Aplicacion

La aplicacion es creada con java springboot, se creo un endpoint solo para modo de pruebas en local. Adicional se realizaron pruebas unitarias garantizando todas las combinaciones
- Se creo una clase service que tiene la logica que detecta si es mutante o es humano.
- Primero se valida que las cadenas tengan valores validos, ya que solo se permite (A,T,C,G), si contiene algun caracter invalido, generara una excepcion personalizada, indicando el mensaje de error.
- Para detectar si es humano se creo un metodo independiente encargado de verificar si existe una secuencia de 4 letras para cada forma (horizontal, vertical, oblicua).
- El algoritmo creado verifica en una matriz de caracteres si existe una secuencia de 4 caracteres en todas sus formas.

# Pruebas

Se realizaron pruebas unitarias sobre la clase service, garantizando las diferentes combinaciones que se pueden presentar para detectar si es un mutante. Adicional tambien se creo pruebas unitarias para la excepcion que se puede generar si el arreglo de string contiene valores que no son validos.
- se garantiza la cobertura de la clase service.

![test-mutant](https://user-images.githubusercontent.com/7538957/144274521-13d87915-0f22-42bb-bb18-d18b29387e7d.png)

![coverage](https://user-images.githubusercontent.com/7538957/144274687-33c05be0-f5cd-443c-9b4b-ce165ec69b0d.png)

