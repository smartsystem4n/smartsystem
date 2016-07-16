#include "configuration.h"
#include <QGraphicsSceneMouseEvent>
#include <QApplication>
#include <QDebug>


Configuration::Configuration()
{
    this->qQuickView = NULL;
}
Configuration::Configuration(QQuickView *qQuickView)
{
    this->qQuickView = qQuickView ;
}

QString Configuration::generateClick()
{

    QGraphicsSceneMouseEvent pressEvent(QEvent::GraphicsSceneMousePress);
    pressEvent.setScenePos(QPointF(0, 0));
    pressEvent.setButton(Qt::LeftButton);
    pressEvent.setButtons(Qt::LeftButton);
    QApplication::sendEvent(this->qQuickView, &pressEvent);

    QGraphicsSceneMouseEvent releaseEvent(QEvent::GraphicsSceneMouseRelease);
    releaseEvent.setScenePos(QPointF(0, 0));
    releaseEvent.setButton(Qt::LeftButton);
    releaseEvent.setButtons(Qt::LeftButton);
    QApplication::sendEvent(this->qQuickView, &releaseEvent);
    qDebug() << "clicked" ;
    return "";
}

