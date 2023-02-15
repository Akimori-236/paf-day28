# INDEXING

## COVERED Queries

```
db.comment.createIndex(
	{ rating : -1}
)
db.comment.find(
	{ "rating" : { $gte : 9 } }
)
```

## TEXT INDEX

```
db.comment.createIndex(
	{c_text : "text"}
)

db.comment.find({
    $text: {
        $search: "enjoy fun",
        $caseSensitive: false
    }
})
```

will search 'enjoy' and 'fun' not 'enjoy fun'

## text score - how well it matches

```
db.comment.find({
    $text: {
        $search: "fun enjoy",
        $caseSensitive: false
    },
    {   
	score: { $meta: "textScore"}
    }
})
.sort({score: -1})
.limit(10)
```

# VARARGS

python `**vargs` == java `String...` or other datatypes

similar to `String[]` or `List<String>`

BUT can be empty

# AGGREGATION

"fieldName" = name of the field

"$fieldName" = value of the field



# WORKSHOP

import playstore into mongo

group by app by category where cat !=NaN
