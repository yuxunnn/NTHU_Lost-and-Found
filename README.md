# 想到什麼要用的就直接寫到上面就好
我每次要做會看一下

# 格式： 需要資料（型態）
如果型態是多層包裝就寫在另一行展開
可以直接看我下面的來寫
英文名字可能會改因為我英文太爛

# 查詢類
用戶(User)： 用戶名(String) 學校(String) 手機(String) 郵箱(String) 密碼(String) 積分(Int) 擁有道具(UserItem) 已發佈的貼文(Post) 任務(Mission) 通知(Noti) 時間(Time) 頭像圖片(String)

貼文(Post)： 圖片(String) 物品類型(String) 地點(String) 作者(User) 物品描述(String) 是否取回(Boolean) 聊天? 懸賞積分(Int) 匿名(Boolean) 時間(Time)

排行榜： 四個學校的積分(Coin) 

任务(Mission): 用戶名(String), 各個任務的進度(Int)

商店道具(ShopItem): 種類(String), 價格(Int),

用戶道具(UserItem): 用戶名(String), 各個道具的數量(Int),

通知：貼文

聊天：發送者(String), 接受者(String), 訊息(String), 時間(Time)

# 修改類

積分 道具 貼文 任務 通知 地點 物品類型

# TODO
