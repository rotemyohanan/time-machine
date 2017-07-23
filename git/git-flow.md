Using Git Flow
--------------

https://danielkummer.github.io/git-flow-cheatsheet/


#### commands order:
----------
    git flow hotfix start 05072017
    git flow hotfix publish 05072017
    git flow hotfix finish '05072017'


Define a hotfix version/TAG, for example: TAG/VERSION== 01062016

##### Before Create:
-------

    git pull develop
    git pull master


##### Before Finish:
-------
    pull develop
    pull master
    pull hotfix/01082016

##### Finish:
------
    git flow hotfix finish 01082016

After Finish:
-------------
    git push origin master
    git push origin develop
    git push origin 01082016


When using the command line:

checkout the relevant branch you wish to be on it.

    git checkout master
    git push (push to the origin/master)

    git checkout develop
    git push (push to the origin/develop)

    git push origin 01062016

#### Error messages:
-------
Console error: 

    Already on 'hotfix/05072017'

Reason:

Your branch is up-to-date with 'origin/hotfix/05072017'.


