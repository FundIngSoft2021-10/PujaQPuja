import 'package:flutter/material.dart';

class Navegador {
  static eliminarPantallaActualYAbrir({@required BuildContext context, @required String nombreRuta}) {
    return Navigator.of(context).pushReplacementNamed(nombreRuta);
  }

  static mantenerPantallaActualYAbrir({@required BuildContext context, @required String nombreRuta}) {
    return Navigator.of(context).pushNamed(nombreRuta);
  }
}
