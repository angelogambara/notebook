<?php
$_ARGS = json_decode(file_get_contents('php://input'), true);

if (!$_ARGS['nome'] || !$_ARGS['cognome']) {
    print json_encode(array('required' => array('nome', 'cognome'), 'optional' => array('telefono')));
    http_response_code(400); die();
}

$_SQL_DELETE = 'DELETE FROM rubrica WHERE nome = "' . $_ARGS['nome'] . '" AND cognome = "' . $_ARGS['cognome'] . '"';

$_SQL_INSERT = 'INSERT INTO rubrica (telefono, nome, cognome) VALUES ("' . $_ARGS['telefono']  . '", "'. $_ARGS['nome']  . '", "'. $_ARGS['cognome'] . '");';

$_SQL_SELECT = 'SELECT telefono FROM rubrica WHERE nome = "' . $_ARGS['nome'] . '" AND cognome = "' . $_ARGS['cognome'] . '"';

$_SQL_UPDATE = 'UPDATE rubrica SET telefono = "' . $_ARGS['telefono'] . '" WHERE nome = "' . $_ARGS['nome'] . '" AND cognome = "' . $_ARGS['cognome'] . '"';

switch ($_SERVER['REQUEST_METHOD']) {
    case 'DELETE':
        $sql = $_SQL_DELETE;
        break;
    case 'INSERT':
        $sql = $_SQL_INSERT;
        break;
    case 'SELECT':
        $sql = $_SQL_SELECT;
        break;
    case 'UPDATE':
        $sql = $_SQL_UPDATE;
        break;
    default:
        print json_encode(array('methods' => array('DELETE', 'INSERT', 'SELECT', 'UPDATE')));
        http_response_code(501); die();
        break;
}

try {
    $conn = new mysqli('localhost', 'root', 'root', 'my_itis5d');
    $result_request = $conn->query($sql);
    $test_not_found = $conn->query($_SQL_SELECT);
} catch (Exception $e) {
    print json_encode(array('internal_server_error' => $e->getMessage()));
    http_response_code(500); die();
}

if ($test_not_found->num_rows === 0 &
        $_SERVER['REQUEST_METHOD'] !== 'DELETE') {
    http_response_code(404); die();
}

if ($result_request === false) {
    http_response_code(500); die();
}

if ($result_request !== true) {
    $row = $result_request->fetch_assoc();
    $result_request->free_result();
    print json_encode(array('telefono' => $row['telefono']));
}

$conn->close();
