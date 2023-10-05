<!DOCTYPE html>
<html>
  <head>
    <?php
      $host = 'localhost';
      $user = 'root';
      $pass = 'root';
      $base = '{{dbname}}';
    ?>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style> body { width: 50em; margin: 0 auto } </style>
    <title>{{title}}</title>
  </head>
  <body>
    <h1>{{title}}</h1>
    <table id='{{table}}'>
      <caption>{{caption}}</caption>
      <th>
        <td>{{tuple}}</td>
        <td>{{tuple}}</td>
        <td>{{tuple}}</td>
      </th>
      <tr>
      <?php
        $mysqli = mysqli_connect($host, $user, $pass, $base);
        $select = '{{query}}';
        $result = mysqli_query($mysqli, $select);
        while($row = mysqli_fetch_assoc($result)) {
          echo '<td>' . $row['{{field}}'] . '</td>'
          echo '<td>' . $row['{{field}}'] . '</td>'
          echo '<td>' . $row['{{field}}'] . '</td>'
        }
      ?>
    </tr>
    </table>
  </body>
</html>
