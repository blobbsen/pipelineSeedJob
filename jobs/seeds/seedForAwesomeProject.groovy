def name = 'pipelineSeedJob'

freeStyleJob(name) {

    logRotator(-1, 10)

    description('foobar')

    scm {
        github('blobbsen/pipelineSeedJob', 'master')
    }

    triggers {
        githubPush()
    }

    steps {
        dsl {
            external('**/**/**/**/**/**/**/**/*.config')
            removeAction('DISABLE')
            ignoreExisting()
        }
    }

}
