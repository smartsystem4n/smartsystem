#include "configuration.h"
#include <QGraphicsSceneMouseEvent>
#include <QApplication>
#include <QDebug>

Configuration::Configuration(QObject *screen)
{
    this->screen = screen ;
    //QTimer *timer = new QTimer(this);
    //connect(timer, SIGNAL(timeout()), this, SLOT(update()));
}

void Configuration::generateClick()
{
    QGraphicsSceneMouseEvent pressEvent(QEvent::GraphicsSceneMousePress);
    pressEvent.setScenePos(QPointF(0, 0));
    pressEvent.setButton(Qt::LeftButton);
    pressEvent.setButtons(Qt::LeftButton);
    QApplication::sendEvent(this->screen, &pressEvent);

    QGraphicsSceneMouseEvent releaseEvent(QEvent::GraphicsSceneMouseRelease);
    releaseEvent.setScenePos(QPointF(0, 0));
    releaseEvent.setButton(Qt::LeftButton);
    releaseEvent.setButtons(Qt::LeftButton);
    QApplication::sendEvent(this->screen, &releaseEvent);
    qDebug() << "clicked" ;
}

