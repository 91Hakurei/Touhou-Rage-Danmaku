package com.wxsf.fhr.main;

import java.awt.Graphics;

import com.wxsf.fhr.model.Bullet;
import com.wxsf.fhr.model.Effect;
import com.wxsf.fhr.model.Enemy;
import com.wxsf.fhr.model.Shoot;
import com.wxsf.fhr.model.SuperObject;

public class ObjectsArray
{

    public ObjectsArray(String s, int j)
    {
        emptySearch = 0;
        arrayMax = j;
        gameObject = new SuperObject[j];
        for(i = 0; i < j; i++)
        {
            if(s.equals("Enemy"))
                gameObject[i] = new Enemy();
            if(s.equals("Bullet"))
                gameObject[i] = new Bullet();
            if(s.equals("Shoot"))
                gameObject[i] = new Shoot();
            if(s.equals("Effect"))
                gameObject[i] = new Effect();
        }

    }

    public void allMove()
    {
        for(i = 0; i < arrayMax; i++)
            if(gameObject[i].getExist())
                gameObject[i].move();

    }

    public void allDraw(Graphics g)
    {
        for(i = 0; i < arrayMax; i++)
            if(gameObject[i].getExist())
                gameObject[i].draw(g);

    }

    public void allErase()
    {
        for(i = 0; i < arrayMax; i++)
            gameObject[i].erase();

    }

    public SuperObject getEmpty()			//���ؿ�������λ
    {
        for(i = 0; i < arrayMax; i++)
        {
            if(!gameObject[emptySearch].getExist())			//���������λδ��ռ��
                return gameObject[emptySearch];				//���ظ�����
            emptySearch++;												//�±�+1
            if(emptySearch >= arrayMax)						//����±곬���涨����
                emptySearch = 0;							//���ص���λ����
        }

        return null;
    }

    public SuperObject getObject(int j)
    {
        return gameObject[j];
    }

    public int getArrayMax()
    {
        return arrayMax;
    }

    private SuperObject gameObject[];
    private int emptySearch;
    private int arrayMax;
    private int i;
}
