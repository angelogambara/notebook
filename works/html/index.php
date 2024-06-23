<?php
$_MYSQLI = new mysqli('localhost', 'admin', 'admin', 'sirio');
$_RESULT = $_MYSQLI -> query('SELECT * FROM controllo');
?>

<!DOCTYPE html>
<html lang="it-IT">
  <head>
    <meta charset="utf-8">
    <link rel="icon" href="/favicon.ico" sizes="any">
    <link rel="stylesheet" href="/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Progetto “Sirio”</title>
  </head>
  <body>
    <h1>Progetto “Sirio”</h1>
    <div class="sirio">
    <?php
      while($row = $_RESULT -> fetch_assoc()) {
        echo '    ' . '<div class="controllo">' . "\n";
        echo '      ' . '<div class="">' . $row[''] . '</div>' . "\n";
        echo '    ' . '</div>' . "\n";
      }
    ?>
    </div>
  </body>
</html>

<?php
$_RESULT -> free_result();
$_MYSQLI -> close();
?>
