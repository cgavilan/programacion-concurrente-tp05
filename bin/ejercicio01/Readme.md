# 1. Gestión de una Piscina Comunitaria

Imagina una piscina comunitaria con un límite máximo de capacidad de personas. Para
asegurarse de que no haya demasiadas personas en la piscina al mismo tiempo y para
evitar aglomeraciones, se implementará un sistema de gestión llamado "GestorPiscina".
La piscina tiene un límite máximo de capacidad y se representa como un recurso
compartido. Las personas llegan a la piscina y desean ingresar para disfrutar del agua y el
sol. El GestorPiscina se encarga de regular el acceso a la piscina de la siguiente manera:

● Si la piscina tiene capacidad disponible, una persona puede ingresar y disfrutar de la
piscina.

● Si la piscina está llena (se alcanzó el límite de capacidad), la persona debe esperar
afuera hasta que alguien salga y libere un espacio.

● Cuando una persona sale de la piscina, su espacio se vuelve disponible para otra
persona que está esperando afuera.

Diseña un programa en el que:
Las personas (hilos) lleguen a la piscina y deseen ingresar, si hay capacidad disponible, la
persona entra y disfruta de la piscina. Si la piscina está llena, la persona debe esperar
afuera hasta que haya espacio disponible.
a) Utiliza semáforos genéricos para gestionar el acceso a la piscina y controlar la
capacidad.
b) Implementa un mecanismo para simular la salida de personas de la piscina y la
liberación de espacios.
