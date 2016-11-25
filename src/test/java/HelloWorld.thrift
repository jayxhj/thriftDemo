namespace java service.demo
 service Hello{
  string helloString(1:string para)
  i32 helloInt(1:i32 para)
  bool helloBoolean(1:bool para)
  void helloVoid()
  string helloNull()
  Column getColumn()
 }

 enum Status {
   DEAD = 0,
   STARTING = 1,
   ALIVE = 2,
   STOPPING = 3,
   STOPPED = 4,
   WARNING = 5,
 }

 struct Column {
    1: optional string name,
    2: optional string value,
    3: optional i64 timestamp,
    4: optional i32 ttl,
 }