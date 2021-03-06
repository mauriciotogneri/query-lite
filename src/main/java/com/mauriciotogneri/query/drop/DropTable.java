package com.mauriciotogneri.query.drop;

import com.mauriciotogneri.query.common.Query;

public class DropTable extends Query
{
    private final String name;
    private final Boolean ifExists;

    private DropTable(String name, Boolean ifExists)
    {
        this.name = name;
        this.ifExists = ifExists;
    }

    DropTable(String name)
    {
        this(name, false);
    }

    public DropTable ifExist()
    {
        return new DropTable(name, true);
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("DROP TABLE");

        if (ifExists)
        {
            builder.append(" IF EXISTS");
        }

        if (name != null)
        {
            builder.append(String.format(" %s", name));
        }

        return builder.toString();
    }
}