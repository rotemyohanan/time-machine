Using Git Flow
--------------

https://danielkummer.github.io/git-flow-cheatsheet/


#### commands order:
----------
    git flow hotfix start 05072017
    git flow hotfix publish 05072017
    git flow hotfix finish '05072017'

Already on 'hotfix/05072017'
Your branch is up-to-date with 'origin/hotfix/05072017'.


Before Finish:
-------------
    pull develop
    pull master
    pull hotfix/01082016

Finish:
------
    git flow hotfix finish 01082016

After Finish:
-------------
    git push origin master
    git push origin develop
    git push origin 01082016
