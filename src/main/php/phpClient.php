<?php
error_reporting(E_ALL);

require_once __DIR__ . "/thrift/lib/Thrift/ClassLoader/ThriftClassLoader.php";
require_once __DIR__ . "/gen-php/Hello.php";
require_once __DIR__ . "/gen-php/Types.php";
use Thrift\ClassLoader\ThriftClassLoader;

$GEN_DIR = realpath(dirname(__FILE__) . "/gen-php");

//加载 Thrift 类库
$loader = new ThriftClassLoader();
$loader->registerNamespace("Thrift", __DIR__ . "/thrift/lib");
$loader->registerDefinition("tService", $GEN_DIR);
$loader->register();

use Thrift\Transport\TSocket;
use Thrift\Transport\TBufferedTransport;
use Thrift\Protocol\TBinaryProtocol;

try {
    $socket = new TSocket('127.0.0.1', 6666);
    $socket->setSendTimeout(60000);
    $socket->setRecvTimeout(60000);
    $socket->setDebug(true);
    $transport = new TBufferedTransport($socket);
    $protocol = new TBinaryProtocol($transport);
    $client = new HelloClient($protocol);

    $transport->open();

    echo $client->helloInt(24) . "\n";
    echo $client->helloString("xuhaojie\n");
    //调用对象
    $column = $client->getColumn();
    var_dump($column);
    echo json_encode($column) . "\n";
} catch (Exception $e) {
    echo $e->getMessage();
} finally {
    $transport->close();
}