package com.xinyu.service;

public interface IRedisService {
    /**
     * 将给定的值与键相关联，存储在Redis中。
     *
     * 此方法用于将指定的键值对存储到Redis中。它使用了RedisTemplate的opsForValue方法来操作Redis中的字符串类型数据。
     * 通过调用set方法，将键和值绑定在一起，实现数据的存储。
     *
     * @param key 键，用于在Redis中唯一标识一个值。
     * @param value 值，可以是任何类型的对象，它将与键相关联并存储在Redis中。
     */
    void setValue(String key, Object value);


    /**
     * 根据键获取存储的值。
     *
     * 本方法通过键值对的形式从Redis缓存中获取指定键对应的值。如果键不存在，则返回null。
     *
     * @param key 缓存中的键，用于唯一标识一个值。
     * @return 缓存中键对应的值，如果键不存在，则返回null。
     */
    public Object getValue(String key);
}
