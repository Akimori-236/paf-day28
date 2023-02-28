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

# Application Design

## Domain entity - model

entity carries across all 3 layers - presentation, business, persistence

leaky abstraction if entity leaks from one layer to another layer

entity has elements from presentation or persistence

entity depends on a import that the rest of the app doesnt use

using Utils to minimise leak




# interview

## last login

sort timestamp desc and get first one


## DB syncing

get records with timestamps more than **
